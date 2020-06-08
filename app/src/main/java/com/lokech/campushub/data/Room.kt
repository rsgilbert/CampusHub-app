package com.lokech.campushub.data

//@Database(entities = [], version = 1)
//abstract class TaxiDatabase : RoomDatabase() {
//    abstract val dao: Dao
//}
//
//private lateinit var INSTANCE: TaxiDatabase
//
//fun getDatabase(context: Context): TaxiDatabase {
//    synchronized(TaxiDatabase::class.java) {
//        if (!::INSTANCE.isInitialized) {
//            INSTANCE = Room.databaseBuilder(
//                context.applicationContext,
//                TaxiDatabase::class.java,
//                "CampusHubDatabase"
//            ).build()
//        }
//    }
//    return INSTANCE
//}