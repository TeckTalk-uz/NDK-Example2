package uz.techtalk.android.ndk

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mlsdev.rximagepicker.RxImagePicker
import com.mlsdev.rximagepicker.Sources
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import uz.techtalk.android.ndk.databinding.ActivityMainBinding
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var job: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCapture.setOnClickListener {
            RxImagePicker.with(supportFragmentManager).requestImage(Sources.CAMERA).subscribe {
                // display original image
                displayImage(it.toFilePath(this), binding.imgOriginView)

                // get a new file path
                val outputPath = getFilePath()

                // call image processor
                processImage(it.toFilePath(this), outputPath?.path)
            }
        }
    }

    // create an instance of image processing
    private val imgProcessing = ImageProcessing(object : ImageProcessingCallback {
        override fun onFailed() {
            runOnUiThread {
                binding.progressView.isVisible = false
                binding.txtStatusView.text = "Failed to read or process!"
            }
        }

        override fun onSuccess(output: String) {
            runOnUiThread {
                binding.progressView.isVisible = false
                binding.txtStatusView.text = "$output"
                displayImage(output, binding.imgProcessedView)
            }
        }
    })

    private fun processImage(inputPath: String?, outputPath: String?) {
        binding.progressView.isVisible = true
        job = CoroutineScope(Dispatchers.IO).launch {
            if (inputPath != null && outputPath != null)
                imgProcessing.findEdges(inputPath, outputPath)
        }
    }

    private fun displayImage(filePath: String?, view: ImageView) {
        Glide
            .with(this)
            .load(filePath)
            .apply(RequestOptions().override(view.width, view.height))
            .into(view)
    }

    private fun getFilePath(): File? {
        // create a folder for saving image
        val imgFolder = Util.makeFolderIfNotExists(this, "NDK")
        // create a file path if folder exists for saving image
        if (Util.makeFolderIfNotExists(File(imgFolder))) {
            return File("$imgFolder/${Util.createFileName()}.jpg")
        }
        return null
    }
}