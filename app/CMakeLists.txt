# sets the minimum version of CMake required to build your native library.
cmake_minimum_required(VERSION 3.4.1)

# Declare global variable to store location of cpp files
set(CPP_ROOT src/main/cpp)

# Path to opencv directory
set(OPENCV_PATH /Users/murodjon/training/OpenCV-android-sdk)

# Import OpenCV
include_directories(${OPENCV_PATH}/sdk/native/jni/include)
add_library(lib_opencv SHARED IMPORTED)
set_target_properties(lib_opencv
        # Specifies the parameter you want to define.
        PROPERTIES IMPORTED_LOCATION
        # Set path to generated libopencv_java.so from stitcher lib
        ${CMAKE_CURRENT_SOURCE_DIR}/src/main/jniLibs/${ANDROID_ABI}/libopencv_java4.so
        )

find_library(
        #defines the name of the path variable that stores the location of NDK library
        log-lib
        # Specifies the name of the NDK library that CMake needs to locate.
        log)

find_library(
        # defines the name of the path variable that stores the location of NDK lib
        android-lib
        # specifies the name of the NDK library
        android)

# add new library
add_library(
        # defines library name
        img-processing-lib
        # set the library as a SHARED
        SHARED
        # provides relative path to your source file
        ${CPP_ROOT}/img-processing-lib.cpp
        ${CPP_ROOT}/img-processing.cpp
)

target_link_libraries(
        # specifies the target library name
        img-processing-lib
        # links opencv library to the target library
        lib_opencv
        # links the android-lib library to the target library
        ${android-lib}
        # links the log-lib library to the target library
        ${log-lib}
)