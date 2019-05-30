package com.example.baitaplay_k.util

import com.example.baitaplay_k.model.Canal
import com.example.baitaplay_k.model.NomeCanal

class SelectCanalUtil {

    companion object {

        fun getCanal(canal: Canal): String {

            var stringCanal = ""

            if (canal.titulo == NomeCanal.BORA_FILMES.nome) {
                stringCanal = "39.m3u8"
            }

            if (canal.titulo == NomeCanal.CLUBINHO.nome) {
                stringCanal = "41.m3u8"
            }

            if (canal.titulo == NomeCanal.REDE_MOSAICO.nome) {
                stringCanal = "27.m3u8"
            }

            if (canal.titulo == NomeCanal.UP_CHANNEL.nome) {
                stringCanal = "42.m3u8"
            }

            if (canal.titulo == NomeCanal.ENTRETER.nome) {
                stringCanal = "37.m3u8"
            }

            if (canal.titulo == NomeCanal.LIFE_CHANNEL.nome) {
                stringCanal = "31.m3u8"
            }

            if (canal.titulo == NomeCanal.HELLO_TV.nome) {
                stringCanal = "44.m3u8"
            }

            if (canal.titulo == NomeCanal.FULL_MUSIC.nome) {
                stringCanal = "28.m3u8"
            }

            if (canal.titulo == NomeCanal.YOU_CHANNEL.nome) {
                stringCanal = "35.m3u8"
            }

            if (canal.titulo == NomeCanal.CANAL_PROMESSA.nome) {
                stringCanal = "36.m3u8"
            }

            if (canal.titulo == NomeCanal.CANAL_24HS.nome) {
                stringCanal = "29.m3u8"
            }

            return stringCanal
        }
    }
}