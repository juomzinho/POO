import { StatusBar } from 'expo-status-bar';
import { StyleSheet, Text, View } from 'react-native';
import { Component, useState } from 'react';
import { TouchableOpacity } from 'react-native';

const App = () => {
  const [data, setData] = useState({nome: 'Joao', year: 2023, color: 'blue'})
    return <View>
      <Text>My name is {data.nome}</Text>
      <Text onPress={()=>setData(props => props.year = 1)}>
        The year is {data.year}</Text>
      <Text>My colors as {data.color}</Text>
    </View>
};

export default App

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
