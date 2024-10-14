package com.pierpaoli.pierpaolilogger;
import android.util.Log;

public class PierpaoliLoggerManager {
    private static final PierpaoliLoggerManager instance = new PierpaoliLoggerManager();
    private static final String LOGTAG = "LOG - > ";

    private PierpaoliLoggerManager()
    {
        Log.i(LOGTAG, "log manager started");
        this.allSavedLogs = "Started plugin";
    }

    public static PierpaoliLoggerManager getInstance() { return instance;}

    private String allSavedLogs = "";

    public void SendLog(String msj)
    {
        Log.i(LOGTAG, "Send LOG: " + msj);
        this.allSavedLogs += "\n" + LOGTAG + msj;
    }

    public String GetLogs()
    {
        Log.i(LOGTAG, "GET ALL: " + this.allSavedLogs);
        return this.allSavedLogs;
    }
}
