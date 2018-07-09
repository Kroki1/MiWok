package com.example.android.miwok;

/**
 * Created by mats on 02/03/2018.

  * {@link Word} represents a vocabulary word that the user wants to learn.
  * It contains a default translation and a Miwok translation for that word.
  */

public class Word {

    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mMiwokTranslation;

    /** Image resource ID for the word */
    private int mImageResourceID = NO_IMAGE_PROVIDED;

    private static final int NO_IMAGE_PROVIDED = -1;

    /**
      * Create a new Word object.
      *
      * @param defaultTranslation is the word in a language that the user is already familiar with
      *                           (such as English)
      * @param miwokTranslation is the word in the Miwok language
      */
    public Word(String defaultTranslation, String miwokTranslation, int imageResourceID) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceID = imageResourceID;

    }

    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;

    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceID() {
        return mImageResourceID;
    }

    public boolean hasImage () {
        // not equal to -1
        return mImageResourceID != NO_IMAGE_PROVIDED;
    }
}
