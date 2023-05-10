import React, { useState } from 'react';
import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import Home from './src/screens/home/Home';
import { NavigationContainer } from '@react-navigation/native';
import { createMaterialBottomTabNavigator } from '@react-navigation/material-bottom-tabs';
import { Ionicons, Entypo } from '@expo/vector-icons'; 
import * as Data from './src/utils/data/data'
import { useFonts, Montserrat_600SemiBold } from '@expo-google-fonts/montserrat';
import { Raleway_300Light, Raleway_400Regular } from '@expo-google-fonts/raleway';
import HomeNav from './src/navigation/HomeNav/HomeNavScreen';
import Liked from './src/screens/liked/Liked';
import Register from './src/screens/register/Register';

const Tab = createMaterialBottomTabNavigator()

export default function App() {
  const [genders, setGenders] = useState(Data.Generos)
  const [music, setMusic] = useState(Data.Musicas)
  const [liked, setLiked] = useState([])

  const addMusic = (musicData) => {
    if(music.filter( item => item.nome === musicData.nome && item.artista === musicData.artista).length > 0){
      alert("Essa musíca já foi adicionada")
      return
    }
    let newMusic = [...music]
    newMusic.push(musicData)
    setMusic(newMusic)
  }

  const like = (musicData) => {
    setLiked(old => [...old, musicData])
  }

  const removeLiked = (musicData) => {
    let copyArr = [...liked]
    copyArr = copyArr.filter(item =>  item != musicData)
    setLiked(copyArr)
  }


  let [fontsLoaded] = useFonts({
    Montserrat_600SemiBold,
    Raleway_300Light,
    Raleway_400Regular
  });

  return (
    <NavigationContainer>
        <Tab.Navigator barStyle={{backgroundColor: "#000"}}
          activeColor="rgba(255,255,255,0.6)"
          inactiveColor="rgba(255,255,255,1)"
          >
        <Tab.Screen name='Inicio'
          options={{
            tabBarLabel: 'Início',
            tabBarIcon: ({ focused, color, size }) => (
                focused?<Ionicons name="md-home" size={24} color="black" />:
                  <Ionicons name="md-home-outline" size={24} color="white" />
              )}}
         >
          {()=><HomeNav genders={genders} musics={music} liked={liked}
            like={like} removeLiked={removeLiked}/>}
        </Tab.Screen>
        <Tab.Screen name='Musicas curtidas'
          options={{
              tabBarLabel: 'Favoritas',
              tabBarIcon: ({focused}) => (
                focused?<Ionicons name="heart" size={24} color="black" />:
                <Ionicons name="heart-outline" size={24} color="white" />
              ),
              tabBarColor: '#FFF',
              
          }}>
          {()=><Liked liked={liked}
            like={like} removeLiked={removeLiked} />}
        </Tab.Screen>
        <Tab.Screen name='Adicionar música'
          options={{
            tabBarLabel: 'Adicionar',
            tabBarIcon: ({focused}) => (
              focused?<Ionicons name="ios-add-circle" size={24} color="black" />:
              <Ionicons name="ios-add-circle-outline" size={24} color="white" />
            )
        }}>
          {()=><Register addMusic={addMusic} genders={genders} />}
        </Tab.Screen>

      </Tab.Navigator>
    </NavigationContainer>
  );
}