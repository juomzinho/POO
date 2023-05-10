import { View, Text } from "react-native-web"
import * as Body from './Styles'
import { Ionicons, MaterialIcons } from "@expo/vector-icons";
import { useRoute, useNavigation } from "@react-navigation/native";

const Category = ({genders, musics, liked, removeLiked, like}) => {
    const route = useRoute()
    const navigation = useNavigation()

    const getIcon = (music) => {
        return liked.includes(music)?'heart-sharp':'heart-outline'
    }

    const toggleFavorite = (music) => {
       return liked.includes(music)?removeLiked(music):like(music)
    }

    
    const getImage = () => {
        let gender = genders.find(item => item.nome === route.params.categoria)
        return gender.imagem
    }

    return( <Body.Container>
        <Body.HeaderImage source={getImage()} />
        <Body.Title>{route.params.categoria}</Body.Title>
        <Body.BackBtn onPress={() => navigation.goBack()}>
            <Ionicons name="chevron-back-sharp" size={24} color="black" />
        </Body.BackBtn>

        <Body.ScrollCategorys
             pagingEnabled={true}
             decelerationRate='fast'
             snapToAlignment={"center"}
             style={{paddingRight: '20px'}}
             >
            {musics.map((item, index) => {
                return item.genero === route.params.categoria? <Body.MusicView key={index.toString()} >
                        <Body.IconContent>
                            <Ionicons name="ios-musical-note" size={20} color="white" />
                        </Body.IconContent>
                        <Body.TitleContent>
                            <Body.TitleMusic>
                                {item.nome}
                            </Body.TitleMusic>
                            <Body.TitleArtist>
                                {item.artista}
                            </Body.TitleArtist>
                        </Body.TitleContent>
                        <Body.LikeContent onPress={()=>toggleFavorite(item)}>
                            <Ionicons name={getIcon(item)} size={20} color="white" />
                        </Body.LikeContent>
                    </Body.MusicView>:null
            })}
        </Body.ScrollCategorys>
    </Body.Container>
    );
}

export default Category