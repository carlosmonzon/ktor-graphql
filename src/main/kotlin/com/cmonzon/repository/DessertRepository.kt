package com.cmonzon.repository

import com.cmonzon.data.desserts
import com.cmonzon.model.Dessert

class DessertRepository : RepositoryInterface<Dessert> {
    override fun getById(id: String): Dessert {
        return desserts.find {
            it.id == id
        } ?: throw Exception("Dessert with id $id not found")
    }

    override fun getAll(): List<Dessert> {
        return desserts
    }

    override fun delete(id: String): Boolean {
        return desserts.remove(
            getById(id)
        )
    }

    override fun add(entry: Dessert): Dessert {
        desserts.add(entry)
        return entry
    }

    override fun update(entry: Dessert): Dessert {
        return getById(entry.id).apply {
            name = entry.name
            description = entry.description
            imageUrl = entry.imageUrl
        }
    }
}