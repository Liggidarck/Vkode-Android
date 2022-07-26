package com.george.vkode

interface IAccountService {
    /**
     * Возвращает или устанавливает токен.
     */
    var token: String?
    /**
     * Возвращает или устанавливает идентификатор пользователя.
     */
    var userId: String?
}