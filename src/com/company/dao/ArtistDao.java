package com.company.dao;

import com.company.model.Artist;

/**
 * Created by user on 30.11.2016.
 */
public class ArtistDao {
    private  Artist[] artists = new Artist[0]; //объявили внутреннее хранилище артистов, 0 - потому
    // что не знаем их количество

    public void add(Artist artist){  //добавлять артиста
        //сначала надо убедиться,что такого артиста еще нет
        int idx = indexOf(artist); //indexOf ищет в массиве и возвращает индекс(порядковый номер) артиста
        if(idx == -1){
            Artist[] tmp = new Artist[artists.length + 1]; //создаем временный массив, длина которого на единицу больше исходного
            tmp[0] = artist; // нулевому эл-ту присвоили значение artist(новый, которого надо добавить в массив), т.е.
            // ставим его на первое место
            for (int i = 1; i < tmp.length ; i++) {
                tmp[i] = artists[i - 1];
            }
            artists = tmp; //присваиваем старому массиву вновь созданный массив
        }else{
            update(artist); // обновляем данные
        }
    }

    public int indexOf(Artist artist) {//этот кусок кода вынесли в отдельный метод indexOf
        int idx = -1; //номер артиста в массиве; присваиваем номер, которого заведомом не будет в массиве
        for (int i = 0; i < artists.length; i++) { //artists.fori + enter
            if(artists[i].getName().equals(artist.getName())) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    public Artist[] getAll(){ //вернуть всех артистов

        return artists;
    }

    public void remove (Artist artist) { //удаление артиста
        int idx = indexOf(artist); //indexOf ищет в массиве и возвращает индекс(порядковый номер) артиста
        if (idx != -1) {
            Artist[] tmp = new Artist[artists.length - 1]; //создаем временный массив, длина которого на единицу меньше исходного

            for (int i = 0; i < tmp.length; i++) {
                if (idx != i && idx < 1) {
                    tmp[i - 1] = tmp[i];

                    tmp = tmp; //присваиваем старому массиву вновь созданный массив
                } else {
                    update(artist); // обновляем данные
                }
            }
        }
    }

    public Artist findByName(String name){ //поиск по имени
        for (int i = 0; i < artists.length; i++) { //задаем имя артиста, сравниваем
            if (artists[i].getName().equals(name)){
                return artists[i];
            }
        }
        return null; //выполнится, если артиста такого нет, т.е вернется пустое значение
    }
    public void update (Artist director){ //обновление данных артиста
        int idx = indexOf(director);
        if (idx!= -1){
            artists[idx].setName(director.getName());
            artists[idx].setAbout(director.getAbout());

        }
    }



}
