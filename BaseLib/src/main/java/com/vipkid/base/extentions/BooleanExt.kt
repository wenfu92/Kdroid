package com.vipkid.base.extentions

/**
 * Created by WWF
 * on 2019/5/4
 */
sealed class BooleanExt<out T>

object Otherwise : BooleanExt<Nothing>()
class WithData<T>(val data: T) : BooleanExt<T>()

inline fun <T> Boolean.yes(block: () -> T) =
        when {
            this -> {
                WithData(block())
            }
            else -> Otherwise
        }

inline fun <T> Boolean.no(block: () -> T) =
        when {
            this -> Otherwise
            else -> WithData(block())
        }

inline infix fun <T> BooleanExt<T>.otherwise(block: () -> T) =
        when (this) {
            is Otherwise -> block()
            is WithData -> this.data
        }

inline operator fun <T> Boolean.invoke(block: () -> T) = yes(block)