package com.company.dao;


import com.company.model.Director;

public class DirectorDao {
    private Director[] directors = new Director[0]; //объявили внутреннее хранилище директоров, 0 - потому
    // что не знаем их количество

    public void add(Director director) {  //добавлять директора
        //сначала надо убедиться,что такого директора еще нет
        int idx = indexOf(director); //indexOf ищет в массиве и возвращает индекс(порядковый номер) диектора
        if (idx == -1) {
            Director[] tmp = new Director[directors.length + 1]; //создаем временный массив, длина которого на единицу больше исходного
            tmp[0] = director; // нулевому эл-ту присвоили значение director(новый, которого надо добавить в массив), т.е.
            // ставим его на первое место
            for (int i = 1; i < tmp.length; i++) {
                tmp[i] = directors[i - 1];
            }
            directors = tmp; //присваиваем старому массиву вновь созданный массив
        } else {
            update(director); // обновляем данные
        }
    }

    public int indexOf(Director director) {//этот кусок кода вынесли в отдельный метод indexOf
        int idx = -1; //номер директора в массиве; присваиваем номер, которого заведомом не будет в массиве
        for (int i = 0; i < directors.length; i++) { //directors.fori + enter
            if (directors[i].getName().equals(director.getName())) {
                idx = i;
                break;
            }
        }
        return idx;
    }

    public Director[] getAll() { //вернуть всех директоров
        return directors;
    }

//    public void remove (Director director) { //удаление директора
//        int idx = indexOf(director); //indexOf ищет в массиве и возвращает индекс(порядковый номер) директора
//        if (idx != -1) {
//            Director[] tmp = new Director[directors.length - 1]; //создаем временный массив, длина которого на единицу меньше исходного
//
//            for (int i = 0; i < directors.length; i++) {
//                if (idx != i && idx < 1) {
//                    tmp[i - 1] = directors[i];
//
//                    directors = tmp; //присваиваем старому массиву вновь созданный массив
//                } else {
//                    update(director); // обновляем данные
//                }
//            }
//        }
//    }

    public void remove(Director director) { //удаление директора
        int idx = indexOf(director);
            Director[] tmp = new Director[directors.length - 1];
            int k = 0;
            for (int i = 0; i < directors.length; i++) {
                if (i == idx) {
                    continue;
                }
                tmp[k] = directors[i];
                k++;
            }
            directors = tmp;
        }





    public Director findByName(String name){ //поиск по имени
        for (int i = 0; i < directors.length; i++) { //задаем имя директора, сравниваем
            if (directors[i].getName().equals(name)){
                return directors[i];
            }
        }
        return null; //выполнится, если директора такого нет, т.е вернется пустое значение
    }
    public void update (Director director){ //обновление данных директора
       int idx = indexOf(director);
       if (idx!= -1){
           directors[idx].setEmail(director.getEmail());
           directors[idx].setPhone(director.getPhone());

       }
    }
}

