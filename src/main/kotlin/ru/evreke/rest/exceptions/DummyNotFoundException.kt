package ru.evreke.rest.exceptions

import java.lang.Exception

class DummyNotFoundException(
    override val message: String?
) : Exception() {

}