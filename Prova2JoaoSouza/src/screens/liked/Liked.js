import { View, Text } from "react-native-web"
import * as Body from './Styles'
import { FontAwesome5, Ionicons } from "@expo/vector-icons";

const Liked = ({liked, like, removeLiked}) => {
    const getIcon = (music) => {
        return liked.includes(music)?'heart-sharp':'heart-outline'
    }

    const toggleFavorite = (music) => {
        return liked.includes(music)?removeLiked(music):like(music)
    }

    return( <Body.Container>
        <Body.Title >
            Favoritas
        </Body.Title>

        {liked.length === 0?<View style={{width: '100%', height: '100%', display: 'flex', alignItems: 'center', justifyContent: 'center'}}>
            <FontAwesome5 name="sad-tear" size={30} color="white" />
            <Body.SubTitle>Não existem músicas favoritadas</Body.SubTitle>
        </View>:null}

        <Body.ScrollCategorys
             pagingEnabled={true}
             decelerationRate='fast'
             snapToAlignment={"center"}
             style={{paddingRight: '20px'}}
             >
            {liked.map((item, index) => {
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

export default Liked