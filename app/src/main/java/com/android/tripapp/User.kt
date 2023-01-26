package com.android.tripapp

import android.app.DownloadManager.Query

data class User(var email: String ?= null, var password: String ?= null, var nickname: String ?= null)