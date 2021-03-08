package com.apps.realestateapp;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.util.Log;
import static org.junit.Assert.*;


@RunWith(AndroidJUnit4.class)
public class UnitTestUI {


    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();


    @Test
    public void UItestPlaceholder() {

        assertEquals(" ", " ");
    }
}