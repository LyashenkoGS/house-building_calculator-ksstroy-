package ua.ksstroy.logic.zone;

import java.util.List;

/*
<<<<<<< HEAD
 * Интерфейс служит для управления таблицей содержащей зоны
=======
 * ��������� ������ ��� ���������� �������� ���������� ����
>>>>>>> 86c2d4d2f842eceee2d529d2cf60ec21e3196ea8
 */

public interface ZoneDataDao {

	/*
<<<<<<< HEAD
	 * добавить имя зоны
=======
	 * �������� ��� ����
>>>>>>> 86c2d4d2f842eceee2d529d2cf60ec21e3196ea8
	 */
	void addZoneName(String zoneName);

	/*
<<<<<<< HEAD
	 * добавить ширину
=======
	 * �������� ������
>>>>>>> 86c2d4d2f842eceee2d529d2cf60ec21e3196ea8
	 */
	void addZoneWidth(Double width);

	/*
<<<<<<< HEAD
	 * добавить высоту
=======
	 * �������� ������
>>>>>>> 86c2d4d2f842eceee2d529d2cf60ec21e3196ea8
	 */

	void addZoneHeight(Double height);

	/*
<<<<<<< HEAD
	 * предполагаем что это произведение ширины на высоту
=======
	 * ������������ ��� ��� ������������ ������ �� ������
>>>>>>> 86c2d4d2f842eceee2d529d2cf60ec21e3196ea8
	 */

	void addZoneValue(Double value);

	/*
<<<<<<< HEAD
	 * получить зону по имени
=======
	 * �������� ���� �� �����
>>>>>>> 86c2d4d2f842eceee2d529d2cf60ec21e3196ea8
	 * 
	 * @return List<ZoneData>
	 */

	List<ZoneData> getAllZoneDataByName(String zoneName);

	/*
<<<<<<< HEAD
	 * добавить дополнительные зоны
=======
	 * �������� �������������� ����
>>>>>>> 86c2d4d2f842eceee2d529d2cf60ec21e3196ea8
	 */

	List<ZoneData> addZoneAdditional(String zoneName, Double width,
			Double height, Double value);

	/*
<<<<<<< HEAD
	 * добавить избыточные зоны
=======
	 * �������� ���������� ����
>>>>>>> 86c2d4d2f842eceee2d529d2cf60ec21e3196ea8
	 */

	List<ZoneData> addZoneSurplus(String zoneName, Double width, Double height,
			Double value);

	/*
<<<<<<< HEAD
	 * добавить величину измерения
=======
	 * �������� �������� ���������
>>>>>>> 86c2d4d2f842eceee2d529d2cf60ec21e3196ea8
	 */

	void addZoneMesureName(String mesureName);

}
