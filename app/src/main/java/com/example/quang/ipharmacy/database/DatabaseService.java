package com.example.quang.ipharmacy.database;

/**
 * Created by VVLv on 04/27/2018.
 */

public class DatabaseService {
    private static Database database = null;
    private DatabaseService() {}

    private static class DatabaseServiceHolder {
        private static final DatabaseService INSTANCE = new DatabaseService();
    }

    public static DatabaseService getInstance() {
        return DatabaseServiceHolder.INSTANCE;
    }

    /*
        TODO: Implement
        - Open & Close : Download & Upload Firebase database
        - Query functions to query data
     */
}