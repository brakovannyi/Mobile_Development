package ru.mirea.suetinan.cryptoloader;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class MyLoader extends AsyncTaskLoader<String> {
    private String firstName;
    private String message;
    public static final String ARG_WORD = "data";
    public static final String ARG_KEY = "key";

    public MyLoader(@NonNull Context context, Bundle args) throws Exception {
        super(context);
        if(args != null) {
            String encodedMessage = args.getString(ARG_WORD);
            String encodedKey = args.getString(ARG_KEY);
            Cipher cipher = Cipher.getInstance("AES");

            byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
            SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
            cipher.init(Cipher.DECRYPT_MODE, originalKey);

            byte[] decryptedMessage = cipher.doFinal(Base64.getDecoder().decode(encodedMessage));
            message = new String(decryptedMessage);
        }
    }

    @Override
    protected void onStartLoading(){
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public String loadInBackground() {
        SystemClock.sleep(5000);
        return message;
    }
}
