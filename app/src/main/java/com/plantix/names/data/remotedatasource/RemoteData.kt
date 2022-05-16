package com.plantix.names.data.remotedatasource

import com.plantix.names.data.names.Names

object RemoteData {
    fun fetchNames(): List<Names> {
        val names = mutableListOf<Names>()
        names.add(Names("elon musk"))
        names.add(Names("bernard arnault"))
        names.add(Names("jeff bezos"))
        names.add(Names("bill gates"))
        names.add(Names("gautam adani"))
        names.add(Names("warren buffett"))
        names.add(Names("larry ellison"))
        names.add(Names("larry page"))
        names.add(Names("sergey brin"))
        names.add(Names("steve ballmer"))
        return names
    }

}
