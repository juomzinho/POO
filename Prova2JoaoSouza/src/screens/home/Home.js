import { View, Text } from "react-native-web"
import * as Body from './Styles'
import { Ionicons, MaterialIcons } from "@expo/vector-icons";
import { useNavigation } from "@react-navigation/native";

const Home = ({ musics, genders, liked, like, removeLiked}) => {

    const navigation = useNavigation()
    const getIcon = (music) => {
        return liked.includes(music)?'heart-sharp':'heart-outline'
    }

    const toggleFavorite = (music) => {
        return liked.includes(music)?removeLiked(music):like(music)
    }

    return( <Body.Container>
        <Body.Title >
            Inicio
        </Body.Title>

        <Body.SubTitle>
            Categorias
        </Body.SubTitle>

        <View style={{height: '110px', width: '100%', overflow: 'hidden'}}>
            <Body.ScrollCategorys
                pagingEnabled={true}
                horizontal= {true}
                decelerationRate='fast'
                snapToAlignment={"center"}
            >
                {genders.map((item, index) => {
                    return  <Body.CategoryBtn key={index.toString()} onPress={()=>navigation.navigate('Categoria', {categoria: item.nome})}>
                                <Body.ImageCategory source={item.imagem}  />
                                <Body.TextBTN>{item.nome}</Body.TextBTN>
                            </Body.CategoryBtn>
                })}
            </Body.ScrollCategorys>
        </View>

        <Body.SubTitle>
            Todas músicas
        </Body.SubTitle>

        <Body.ScrollCategorys
             pagingEnabled={true}
             decelerationRate='fast'
             snapToAlignment={"center"}
             style={{paddingRight: '20px'}}
             >
            {musics.map((item, index) => {
                return  <Body.MusicView key={index.toString()} >
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
                        <Ionicons name={getIcon(item)} size={24} color="white" />
                    </Body.LikeContent>
                </Body.MusicView>
            })}
        </Body.ScrollCategorys>

    </Body.Container>
    );
}

export default Home