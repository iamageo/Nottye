package com.iamageo.domain.util

sealed class OrderType {
    object Ascending : OrderType()
    object Descending : OrderType()
}