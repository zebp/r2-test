package org.example

import aws.sdk.kotlin.runtime.auth.credentials.StaticCredentialsProvider
import aws.sdk.kotlin.services.s3.S3Client
import aws.sdk.kotlin.services.s3.listObjects
import aws.smithy.kotlin.runtime.net.url.Url

suspend fun main() {
    val bucketName = "testing"
    val accountId = ""
    val accessKeyId = ""
    val accessKeySecret = ""
    val client = S3Client {
        region = "auto"
        endpointUrl = Url.parse("https://$accountId.r2.cloudflarestorage.com")
        credentialsProvider = StaticCredentialsProvider {
            this.accessKeyId = accessKeyId
            this.secretAccessKey = accessKeySecret
        }
    }

    val objects = client.listObjects { bucket = bucketName }
    val contents = objects.contents ?: return

    for (obj in contents.iterator()) {
        println(obj.key)
    }
}