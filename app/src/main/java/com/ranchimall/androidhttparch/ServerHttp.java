package com.ranchimall.androidhttparch;

import android.content.Context;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import fi.iki.elonen.NanoHTTPD;

//Class to host local http server
public class ServerHttp extends NanoHTTPD {
    private Context mContext;
    private static final String TAG = "Application";
    public ServerHttp(Context context, int port) throws IOException {
        super(port);
        mContext=context;
        start();
    }

    @Override
    public Response serve(IHTTPSession session) {
        String uri = session.getUri();
        Log.d(TAG,"Incoming HTTP Request : "+uri.substring(1));
        try {
            if (uri.contains(".html")) {
                InputStream is = mContext.getAssets().open(uri.substring(1));
                return newChunkedResponse(Response.Status.OK, "text/html", is);
            }
        } catch (IOException e) {
            Log.d(TAG,"Error opening file : "+uri.substring(1));
            e.printStackTrace();
        }
        return  null;
    }
}
