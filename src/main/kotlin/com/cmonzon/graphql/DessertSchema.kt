package com.cmonzon.graphql

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.cmonzon.model.Dessert
import com.cmonzon.model.DessertInputDTO
import com.cmonzon.repository.DessertRepository
import java.util.*

fun SchemaBuilder.dessertSchema() {
    val repository = DessertRepository()
    inputType<DessertInputDTO> {
        description = "This is the data transfer object of the dessert"
    }

    type<Dessert> {
        description = "Dessert object with attributes"
    }

    query("dessert") {
        resolver { dessertId: String ->
            repository.getById(dessertId)
        }
    }

    query("desserts") {
        resolver { ->
            repository.getAll()
        }
    }

    mutation("createDessert") {
        description = "create a new dessert"
        resolver { dessertInputDTO: DessertInputDTO ->
            val uid = UUID.randomUUID().toString()
            val dessert = Dessert(uid, dessertInputDTO.name, dessertInputDTO.description, dessertInputDTO.imageUrl)
            repository.add(dessert)
        }
    }
}