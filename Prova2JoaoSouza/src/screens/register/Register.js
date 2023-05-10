import React, {useState} from "react";
import * as Body from './Styles'
import { AntDesign, Ionicons, MaterialIcons } from "@expo/vector-icons";
import { Picker } from "react-native-web";

const Register = ({addMusic, genders}) => {
    const [nome, setNome] = useState('')
    const [artista, setArtista] = useState('')
    const [genero, setGenero] = useState('')

    const add = () => {
        if(nome.length === 0 || artista.length === 0 || genero.length === 0){
            alert("Preencha todos os campos")
            return
        }

        addMusic({nome, artista, genero})
        setArtista('')
        setNome('')
        setGenero('')
    }

    return <Body.Container>
        <Body.Title>
            Cadastrar música
        </Body.Title>

        <Body.InputContent>
            <Body.IconInput>
            <Ionicons name="ios-musical-note" size={24} color="rgba(255,255,255,0.8)" />
            </Body.IconInput>
            <Body.Input value={nome} onChangeText={setNome} placeholder="Nome" />
        </Body.InputContent>

        <Body.InputContent>
            <Body.IconInput>
             <AntDesign name="user" size={24} color="rgba(255,255,255,0.8)" />
            </Body.IconInput>
            <Body.Input value={artista} onChangeText={setArtista} placeholder="Artista"/>
        </Body.InputContent>

        <Body.InputContent>
            <Body.IconInput>
            <MaterialIcons name="category" size={24} color="white" />
            </Body.IconInput>
            <Body.Picker value={genero} onValueChange={(itemValue, itemIndex) => setGenero(itemValue)} >
                {genders.map((item, index)=>{
                     return <Picker.Item label={item.nome} value={item.nome} 
                        key={index.toString()} styles={{paddingLeft: '0px'}} />
                })}
            </Body.Picker>
        </Body.InputContent>

        <Body.Button onPress={()=>add()}>
            <Body.ButtonText>Adicionar</Body.ButtonText>
        </Body.Button>
    </Body.Container>
}

export default Register