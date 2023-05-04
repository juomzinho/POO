import 'react-native-gesture-handler';
import React, { Component } from 'react'
import Home from '../../screens/home/Home';
import { NavigationContainer } from '@react-navigation/native'
import { createStackNavigator } from '@react-navigation/stack';
import Category from '../../screens/category/Category';

const Navigator = createStackNavigator()

const HomeNav = ({musics, genders, liked, like, removeLiked}) => {
    return <Navigator.Navigator screenOptions={{headerShown: false}}>
        <Navigator.Screen name="Home">
            {()=><Home musics={musics} genders={genders} like={like} liked={liked}
                removeLiked={removeLiked}/>}
        </Navigator.Screen>
        <Navigator.Screen name='Categoria'>
            {()=><Category genders={genders} musics={musics} liked={liked}
                 removeLiked={removeLiked} like={like} />}
        </Navigator.Screen>
    </Navigator.Navigator>
}

export default HomeNav