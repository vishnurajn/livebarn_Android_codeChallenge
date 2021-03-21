package com.vishnuraj.surfaces.data

import com.google.gson.annotations.SerializedName



class Post {
    @SerializedName("id")
    private var id: Int? = null

    @SerializedName("surfaceName")
    private var surfaceName: String? = null

    @SerializedName("status")
    private var status: String? = null

    @SerializedName("venueName")
    private var venueName: String? = null

    @SerializedName("sport")
    private var sport: String? = null

    @SerializedName("server")
    private var server: Server? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getSurfaceName(): String? {
        return surfaceName
    }

    fun setSurfaceName(surfaceName: String?) {
        this.surfaceName = surfaceName
    }

    fun getStatus(): String? {
        return status
    }

    fun setStatus(status: String?) {
        this.status = status
    }

    fun getVenueName(): String? {
        return venueName
    }

    fun setVenueName(venueName: String?) {
        this.venueName = venueName
    }

    fun getSport(): String? {
        return sport
    }

    fun setSport(sport: String?) {
        this.sport = sport
    }

    fun getServer(): Server? {
        return server
    }

    fun setServer(server: Server?) {
        this.server = server
    }
}