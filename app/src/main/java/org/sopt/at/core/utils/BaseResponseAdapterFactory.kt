package org.sopt.at.core.utils

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken
import java.lang.reflect.ParameterizedType

class BaseResponseAdapterFactory : TypeAdapterFactory {
    override fun <T> create(gson: Gson, type: TypeToken<T>): TypeAdapter<T>? {
        val rawType = type.rawType
        if (rawType != BaseResponse::class.java) {
            return null
        }

        val dataType = (type.type as? ParameterizedType)?.actualTypeArguments?.firstOrNull()
            ?: return null

        val delegate = gson.getDelegateAdapter(this, TypeToken.getParameterized(BaseResponse::class.java, dataType))
        return delegate as TypeAdapter<T>
    }
}