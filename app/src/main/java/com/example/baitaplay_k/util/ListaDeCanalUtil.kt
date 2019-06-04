package com.example.baitaplay_k.util

import com.example.baitaplay_k.R
import com.example.baitaplay_k.model.Canal
import com.example.baitaplay_k.model.DescricaoCanal
import com.example.baitaplay_k.model.NomeCanal

class ListaDeCanalUtil {

    companion object {
        fun listaDeNavegacao(): List<Canal> {

            return listOf(
                Canal(NomeCanal.BORA_FILMES.nome, R.mipmap.ic_bora_filmes,DescricaoCanal.BORA_FILMES.descr),
                Canal(NomeCanal.CLUBINHO.nome, R.mipmap.ic_clubinho,DescricaoCanal.CLUBINHO.descr),
                Canal(NomeCanal.REDE_MOSAICO.nome, R.mipmap.ic_mosaico,DescricaoCanal.REDE_MOSAICO.descr),
                Canal(NomeCanal.UP_CHANNEL.nome, R.mipmap.ic_up_channel,DescricaoCanal.UP_CHANNEL.descr),
                Canal(NomeCanal.ENTRETER.nome, R.mipmap.ic_entreter, DescricaoCanal.ENTRETER.descr),
                Canal(NomeCanal.LIFE_CHANNEL.nome, R.mipmap.ic_life_channel,DescricaoCanal.LIFE_CHANNEL.descr),
                Canal(NomeCanal.HELLO_TV.nome, R.mipmap.ic_hello_tv,DescricaoCanal.HELLO_TV.descr),
                Canal(NomeCanal.FULL_MUSIC.nome, R.mipmap.ic_full_music,DescricaoCanal.FULL_MUSIC.descr),
                Canal(NomeCanal.YOU_CHANNEL.nome, R.mipmap.ic_yu_channel,DescricaoCanal.YOU_CHANNEL.descr),
                Canal(NomeCanal.CANAL_PROMESSA.nome, R.mipmap.ic_canal_promessas,DescricaoCanal.CANAL_PROMESSA.descr),
                Canal(NomeCanal.CANAL_24HS.nome, R.mipmap.ic_24h_new,DescricaoCanal.CANAL_24HS.descr)
            )
        }

        fun listaDeCardCanais(): List<Canal> {

            return listOf(
                Canal(NomeCanal.BORA_FILMES.nome, R.drawable.bora_filmes, DescricaoCanal.BORA_FILMES.descr),
                Canal(NomeCanal.CLUBINHO.nome, R.drawable.clubinho, DescricaoCanal.CLUBINHO.descr),
                Canal(NomeCanal.REDE_MOSAICO.nome, R.drawable.mosaico, DescricaoCanal.REDE_MOSAICO.descr),
                Canal(NomeCanal.UP_CHANNEL.nome, R.drawable.up_channel, DescricaoCanal.UP_CHANNEL.descr),
                Canal(NomeCanal.ENTRETER.nome, R.drawable.canal_entreter, DescricaoCanal.ENTRETER.descr),
                Canal(NomeCanal.LIFE_CHANNEL.nome, R.drawable.life_channel, DescricaoCanal.LIFE_CHANNEL.descr),
                Canal(NomeCanal.HELLO_TV.nome, R.drawable.hello_tv, DescricaoCanal.HELLO_TV.descr),
                Canal(NomeCanal.FULL_MUSIC.nome, R.drawable.full_music, DescricaoCanal.FULL_MUSIC.descr),
                Canal(NomeCanal.YOU_CHANNEL.nome, R.drawable.you_channel, DescricaoCanal.YOU_CHANNEL.descr),
                Canal(NomeCanal.CANAL_PROMESSA.nome, R.drawable.ic_promessas, DescricaoCanal.CANAL_PROMESSA.descr),
                Canal(NomeCanal.CANAL_24HS.nome, R.drawable._24h_news, DescricaoCanal.CANAL_24HS.descr)
            )
        }

    }


}