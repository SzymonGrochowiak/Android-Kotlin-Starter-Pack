package com.szymongrochowiak.androidkotlinstarterpack.data.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

/**
 * @author Szymon Grochowiak
 */
@Entity data class Berry(@Id var id: Long, var name: String)