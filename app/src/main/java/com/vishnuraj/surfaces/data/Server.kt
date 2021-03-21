package com.vishnuraj.surfaces.data

import com.google.gson.annotations.SerializedName



class Server {
    @SerializedName("id")
    private var id: Int? = null

    @SerializedName("ip4")
    private var ip4: String? = null

    @SerializedName("dns")
    private var dns: String? = null

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int?) {
        this.id = id
    }

    fun getIp4(): String? {
        return ip4
    }

    fun setIp4(ip4: String?) {
        this.ip4 = ip4
    }

    fun getDns(): String? {
        return dns
    }

    fun setDns(dns: String?) {
        this.dns = dns
    }
}
