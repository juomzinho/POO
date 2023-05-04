import { SafeAreaView, View, Text, TouchableOpacity } from "react-native-web";
import styled from "styled-components/native";
import { Montserrat_600SemiBold } from "@expo-google-fonts/montserrat";

export const Container = styled.View`
  flex: 1;
  background-color: #171717;
  padding: 20px;
  padding-right: 0;
  padding-bottom: 5px;
`

export const Title = styled.Text`
  color: #FFF;
  font-size: 24px;
  font-weight: 600;
  margin-bottom: 10px;
  font-family: Montserrat_600SemiBold
`

export const Button = styled.TouchableOpacity`
  width: 100%;
  height: 65px;
  background: #040404;
  border-radius: 20px;
  display: flex;
  flex-direction: row;
  padding: 20px;
  box-sizing: border-box;
  align-items: center;
  grid-gap: 10px 10px;
`

export const TextBTN = styled.Text`
  color: #FFF;
  font-family: Raleway_400Regular;
  position: absolute;
  bottom: 10px;
`

export const SubTitle = styled.Text`
  color: #FFF;
  font-family: Raleway_300Light;
  font-size: 20px;
  margin-top: 20px;
  margin-bottom: 15px;
  
`

export const CategoryBtn = styled.TouchableOpacity`
  width: 90px;
  height: 100px;
  background: #000;
  border-radius: 20px;
  margin-right: 10px;
  display: flex;
  flex-direction: column;
  align-items: center;
  position: relative;
`

export const ImageCategory = styled.Image`
  width: 90px;
  height: 90px;
  border-top-left-radius: 20px;
  border-top-right-radius: 20px;
  -webkit-mask-image: linear-gradient(to top, transparent 25%, black 100%)
`

export const ScrollCategorys = styled.ScrollView`
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  overflow: hidden
`

export const MusicView = styled.View`
  width: calc(100vw - 40px);
  height: 50px;
  background: #000;
  margin-bottom: 5px;
  border-radius: 12px;
  padding: 10px;
  display: flex;
  flex-direction: row;
  grid-gap: 0px 10px;
  position: relative;
`

export const TitleContent = styled.View`
`

export const IconContent = styled.View`
  width: 30px;
  height: 30px;
  background: #0E0E0E;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 6px;
`

export const TitleMusic = styled.Text`
  color: #FFF;
`

export const TitleArtist = styled.Text`
  color: rgba(255,255,255,0.8);
  font-size: 12px;
`

export const LikeContent = styled.TouchableOpacity`
  position: absolute;
  right: 10px;
`