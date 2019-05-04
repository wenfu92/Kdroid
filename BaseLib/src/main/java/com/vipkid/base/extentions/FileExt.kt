package com.vipkid.base.extentions

import android.util.Log
import java.io.File

/**
 * Created by WWF
 * on 2019/5/4.
 */
private const val TAG = "FileExt"

fun File.ensureDir(): Boolean {
    try {
        isDirectory.no {
            isFile {
                delete()
            }
            return mkdirs()
        }
    } catch (e: Exception) {
        Log.w(TAG, e.message)
    }
    return false
}

fun File.deleteDir(): Boolean {
    if (isDirectory) {
        val children = list()
        (children != null && children.isNotEmpty()) {
            children.forEach {
                val success = File(this, it).deleteDir()
                if (!success) return false
            }
        } otherwise {
            return delete()
        }
    } else if (exists()) {
        return delete()
    }
    return true
}