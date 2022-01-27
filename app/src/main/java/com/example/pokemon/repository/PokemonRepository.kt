package com.example.pokemon.repository

import android.util.Log
import com.example.pokemon.data.remote.PokeApi
import com.example.pokemon.data.remote.responses.Pokemon
import com.example.pokemon.data.remote.responses.PokemonList
import com.example.pokemon.util.Resource
import dagger.Provides
import dagger.hilt.android.scopes.ActivityScoped
import java.lang.Exception
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokeApi
) {
    suspend fun getPokemonList(limit: Int, offset: Int) : Resource<PokemonList> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }

        return Resource.Success(response)

        Log.d("ekhane", response.toString())
    }

    suspend fun getPokemonInfo(pokemonName: String) : Resource<Pokemon> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error("An unknown error occurred.")
        }

        return Resource.Success(response)

        Log.d("ekhane", response.toString())
    }

}