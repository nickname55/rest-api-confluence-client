package com.pampushko.confluence.models.macros;

import com.pampushko.confluence.models.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * объект содержащий параметры макроса
 * <br />
 */
@Slf4j
@Setter
@Getter
@EqualsAndHashCode
public class Parameters extends BaseModel
{
	
	Map<String, String> param;
	//todo добавить свойства. Наверное у различных макросов бывают различные наборы свойств, потому необходимо предусмотреть специальный сериализатор/десериализатор для объекта данного класса
}
