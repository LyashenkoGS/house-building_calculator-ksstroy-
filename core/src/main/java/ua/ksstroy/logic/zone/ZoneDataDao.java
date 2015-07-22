package ua.ksstroy.logic.zone;

import java.util.List;

/*
 * ��������� ������ ��� ���������� �������� ���������� ����
 */

public interface ZoneDataDao {

	/*
	 * �������� ��� ����
	 */
	void addZoneName(String zoneName);

	/*
	 * �������� ������
	 */
	void addZoneWidth(Double width);

	/*
	 * �������� ������
	 */

	void addZoneHeight(Double height);

	/*
	 * ������������ ��� ��� ������������ ������ �� ������
	 */

	void addZoneValue(Double value);

	/*
	 * �������� ���� �� �����
	 * 
	 * @return List<ZoneData>
	 */

	List<ZoneData> getAllZoneDataByName(String zoneName);

	/*
	 * �������� �������������� ����
	 */

	List<ZoneData> addZoneAdditional(String zoneName, Double width,
			Double height, Double value);

	/*
	 * �������� ���������� ����
	 */

	List<ZoneData> addZoneSurplus(String zoneName, Double width, Double height,
			Double value);

	/*
	 * �������� �������� ���������
	 */

	void addZoneMesureName(String mesureName);

}
