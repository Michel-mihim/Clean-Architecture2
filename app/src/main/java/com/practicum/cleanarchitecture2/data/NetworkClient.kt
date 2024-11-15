package com.practicum.cleanarchitecture2.data

import com.practicum.cleanarchitecture2.data.dto.Response

interface NetworkClient {
    fun doRequest(dto: Any): Response
}