package com.arifahmadalfian.rawgapp.domain.model.commons

interface IPaginate<Key, Item> {
    suspend fun loadNextItems()
    fun reset()
}

class Paginate<Key, Item>(
    private val initialKey: Key,
    private inline val onLoadUpdated: (Boolean) -> Unit,
    private inline val onRequest: suspend (nextKey: Key) -> ResourceState<Item>,
    private inline val getNextKey: suspend (Item) -> Key,
    private inline val onError: suspend (String?) -> Unit,
    private inline val onSuccess: suspend (item: Item, newKey: Key) -> Unit
): IPaginate<Key, Item> {

    private var currentKey = initialKey
    private var isMakingRequest = false

    override suspend fun loadNextItems() {
        if(isMakingRequest) {
            return
        }
        isMakingRequest = true
        onLoadUpdated(true)
        val result = onRequest(currentKey)
        isMakingRequest = false
        if (result.data != null) {
            currentKey = getNextKey(result.data)
            onSuccess(result.data, currentKey)
        } else {
            onError(result.message)
        }
        onLoadUpdated(false)
    }

    override fun reset() {
        currentKey = initialKey
    }
}