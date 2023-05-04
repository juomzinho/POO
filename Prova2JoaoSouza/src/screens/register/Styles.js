import { SafeAreaView, View, Text, TouchableOpacity } from "react-native-web";
import styled from "styled-components/native";
import { Montserrat_600SemiBold } from "@expo-google-fonts/montserrat";

export const Container = styled.View`
  flex: 1;
  background-color: #171717;
  padding: 20px;
`

export const Title = styled.Text`
  color: #FFF;
  font-size: 24px;
  font-weight: 600;
  margin-bottom: 10px;
  font-family: Montserrat_600SemiBold
`

export const InputContent = styled.View`
    position: relative;
    width: 100%;
    display: flex;
    justify-content: center;
    height: 40px;
    margin-bottom: 10px;
`

export const Input = styled.TextInput`
    width: 100%;
    height: 40px;
    border-radius: 6px;
    border: 1px solid rgba(255,255,255,0.6);
    padding-left: 40px;
    color: #FFF;
    font-family: Raleway_400Regular;
    active:{
        border: 1px solid rgba(255,255,255,1);
    }
`

export const IconInput = styled.View`
    position: absolute;
    left: 10px;
`

export const Picker = styled.Picker`
    background: #171717;
    color: #FFF;
    height: 40px;
    border-radius: 6px;
    padding-left: 35px;
    font-family: Raleway_400Regular
`

export const Button = styled.TouchableOpacity`
    width: 100%;
    height: 45px;
    background: #FFF;
    border-radius: 12px;
    display: flex;
    align-items: center;
    justify-content: center;
    `

export const ButtonText = styled.Text`
    color: #000;
    font-family: Raleway_400Regular
`