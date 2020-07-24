package br.com.souzabrunoj.data

import java.util.*
import java.util.concurrent.ThreadLocalRandom

fun randomString() = UUID.randomUUID().toString()

fun randomBoolean() = Math.random() < 0.5

fun randomInt() = ThreadLocalRandom.current().nextInt(0, 1000 + 1)

fun randomLong() = randomInt().toLong()

fun randomFloat() = ThreadLocalRandom.current().nextLong()

fun randomDouble() = ThreadLocalRandom.current().nextDouble()

fun randomDateAsString() = Date(randomLong()).toString()

fun randomDate() = Date(randomLong())

fun randomCalendar(): Calendar = Calendar.getInstance()

fun randomEmail() = "${randomString()}@ioasys.com.br"
