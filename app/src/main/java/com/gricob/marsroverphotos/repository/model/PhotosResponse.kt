package com.gricob.marsroverphotos.repository.model

import androidx.room.*
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.*

data class PhotosResponse(

	@field:SerializedName("photos")
	val photos: List<PhotosItem?>? = null
)

data class Rover(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("launch_date")
	val launchDate: String? = null,

	@field:SerializedName("landing_date")
	val landingDate: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class Camera(

	@field:SerializedName("full_name")
	@Ignore val fullName: String? = null,

	@field:SerializedName("name")
	@ColumnInfo(name = "camera_name") var name: String? = null,

	@field:SerializedName("id")
	@Ignore val id: Int? = null,

	@field:SerializedName("rover_id")
	@Ignore val roverId: Int? = null
)

@Entity(tableName = "photos_table")
data class PhotosItem(

	@field:SerializedName("sol")
	@Ignore val sol: Int? = null,

	@field:SerializedName("earth_date")
	var earthDate: String? = null,

	@field:SerializedName("id")
	@PrimaryKey var id: Int? = null,

	@field:SerializedName("camera")
	@Embedded var camera: Camera? = null,

	@field:SerializedName("rover")
	@Ignore val rover: Rover? = null,

	@field:SerializedName("img_src")
	var imgSrc: String? = null
): Serializable
