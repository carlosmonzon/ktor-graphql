package com.cmonzon.model

// domain
data class Dessert(override val id: String, var name: String, var description: String, var imageUrl: String) : Model

// data transfer objects
data class DessertInputDTO(var name: String, var description: String, var imageUrl: String)