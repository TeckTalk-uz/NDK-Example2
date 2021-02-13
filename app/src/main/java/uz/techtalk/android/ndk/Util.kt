package uz.techtalk.android.ndk

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.text.format.DateFormat
import java.io.File
import java.util.*

/**
 * Created by murodjon on 2021/02/11
 */
object Util {

    /**
     * Creates file name based on current time.
     */
    fun createFileName(): String {
        val calendar = GregorianCalendar()
        calendar.timeZone = TimeZone.getDefault()
        val dateTaken = calendar.timeInMillis
        return DateFormat.format("yyyyMMdd_kkmmss", dateTaken)
            .toString() + (dateTaken % 1000).toString()
    }

    fun makeFolderIfNotExists(
        context: Context,
        dirName: String?
    ): String? {
        val outDir = File(context.getExternalFilesDir(null), dirName)
        return if (!outDir.exists() && !outDir.mkdirs()) {
            null
        } else outDir.absolutePath
    }

    fun makeFolderIfNotExists(file: File): Boolean {
        return !(!file.exists() && !file.mkdirs())
    }
}


@SuppressLint("Recycle")
fun Uri.toFilePath(context: Context): String? {
    val projection = arrayOf(MediaStore.Images.Media.DATA)
    val cursor: Cursor = context.contentResolver.query(this, projection, null, null, null) ?: return null
    val columnIndex: Int = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
    if (!cursor.moveToFirst()) return null
    val s: String = cursor.getString(columnIndex)
    cursor.close()
    return s
}