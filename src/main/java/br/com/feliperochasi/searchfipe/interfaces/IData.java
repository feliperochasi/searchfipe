package br.com.feliperochasi.searchfipe.interfaces;

import java.util.List;

public interface IData {
    <T> T getData(String json, Class<T> tClass);
    <T> List<T> getList(String json, Class<T> tClass);
}
