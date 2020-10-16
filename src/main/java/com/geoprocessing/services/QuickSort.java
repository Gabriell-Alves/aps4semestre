package com.geoprocessing.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.geoprocessing.entities.Coordinate;
import com.geoprocessing.entities.Ordination;

@Service
public class QuickSort implements OrdinationInterface {

	private List<Coordinate> coordinates = new ArrayList<>();

	@Override
	public List<Coordinate> addList(List<Coordinate> list, Ordination newObj, String orderBy) {
		this.coordinates = list;
		updateOrdination(newObj, orderBy);
		ordination(this.coordinates, orderBy);
		return this.coordinates;
	}

	@Override
	public Long ordination(List<Coordinate> list, String orderBy) {
		Long startOfordinationing = System.currentTimeMillis();
		switch (orderBy) {
		case "longitude":
			ordinationPerLongitude(list);
			break;
		case "latitude":
			ordinationPerLatitude(list);
			break;
		case "situation":
			ordinationPerSituation(list);
			break;
		case "id":
			ordinationPerId(list);
			break;
		default:
			break;
		}
		Long endOfordinationing = System.currentTimeMillis();
		return endOfordinationing - startOfordinationing;
	}

	@Override
	public void updateOrdination(Ordination obj, String orderBy) {
		obj.setElements100(ordination(coordinates.stream().limit(100).collect(Collectors.toList()), orderBy));
		obj.setElements1000(ordination(coordinates.stream().limit(1000).collect(Collectors.toList()), orderBy));
		obj.setElements10000(ordination(coordinates.stream().limit(10000).collect(Collectors.toList()), orderBy));
		obj.setElements100000(ordination(coordinates.stream().limit(100000).collect(Collectors.toList()), orderBy));
	}

	@Override
	public void ordinationPerLatitude(List<Coordinate> list) {
		quickSortPerLatitude(list, 0, list.size() - 1);

	}

	private void quickSortPerLatitude(List<Coordinate> list, int start, int end) {
		if (start < end) {
			int pivotPosition = separatePerLatitude(list, start, end);
			quickSortPerLatitude(list, start, pivotPosition - 1);
			quickSortPerLatitude(list, pivotPosition + 1, end);
		}
	}

	private int separatePerLatitude(List<Coordinate> list, int start, int end) {
		Coordinate pivot = list.get(start);
		int i = start + 1, f = end;
		while (i <= f) {
			if (list.get(i).getLatitude() <= pivot.getLatitude())
				i++;
			else if (pivot.getLatitude() < list.get(f).getLatitude())
				f--;
			else {
				Coordinate swap = list.get(i);
				list.set(i, list.get(f));
				list.set(f, swap);
				i++;
				f--;
			}
		}
		list.set(start, list.get(f));
		list.set(f, pivot);
		return f;
	}

	@Override
	public void ordinationPerLongitude(List<Coordinate> list) {
		quickSortPerLongitude(list, 0, list.size() - 1);

	}

	private void quickSortPerLongitude(List<Coordinate> list, int start, int end) {
		if (start < end) {
			int pivotPosition = separatePerLongitude(list, start, end);
			quickSortPerLongitude(list, start, pivotPosition - 1);
			quickSortPerLongitude(list, pivotPosition + 1, end);
		}
	}

	private int separatePerLongitude(List<Coordinate> list, int start, int end) {
		Coordinate pivot = list.get(start);
		int i = start + 1, f = end;
		while (i <= f) {
			if (list.get(i).getLongitude() <= pivot.getLongitude())
				i++;
			else if (pivot.getLongitude() < list.get(f).getLongitude())
				f--;
			else {
				Coordinate swap = list.get(i);
				list.set(i, list.get(f));
				list.set(f, swap);
				i++;
				f--;
			}
		}
		list.set(start, list.get(f));
		list.set(f, pivot);
		return f;
	}

	@Override
	public void ordinationPerSituation(List<Coordinate> list) {
		quickSortPerSituation(list, 0, list.size() - 1);

	}

	private void quickSortPerSituation(List<Coordinate> list, int start, int end) {
		if (start < end) {
			int pivotPosition = separatePerSituation(list, start, end);
			quickSortPerSituation(list, start, pivotPosition - 1);
			quickSortPerSituation(list, pivotPosition + 1, end);
		}
	}

	private int separatePerSituation(List<Coordinate> list, int start, int end) {
		Coordinate pivot = list.get(start);
		int i = start + 1, f = end;
		while (i <= f) {

			if (list.get(i).getSituation().compareTo(pivot.getSituation()) >= 0)
				i++;
			else if (pivot.getSituation().compareTo(list.get(f).getSituation()) < 0)
				f--;
			else {
				Coordinate swap = list.get(i);
				list.set(i, list.get(f));
				list.set(f, swap);
				i++;
				f--;
			}
		}
		list.set(start, list.get(f));
		list.set(f, pivot);
		return f;
	}

	@Override
	public void ordinationPerId(List<Coordinate> list) {
		quickSortPerId(list, 0, list.size() - 1);

	}

	private void quickSortPerId(List<Coordinate> list, int start, int end) {
		if (start < end) {
			int pivotPosition = separatePerId(list, start, end);
			quickSortPerId(list, start, pivotPosition - 1);
			quickSortPerId(list, pivotPosition + 1, end);
		}
	}

	private int separatePerId(List<Coordinate> list, int start, int end) {
		Coordinate pivot = list.get(start);
		int i = start + 1, f = end;
		while (i <= f) {
			if (list.get(i).getLatitude() <= pivot.getLatitude())
				i++;
			else if (pivot.getLatitude() < list.get(f).getLatitude())
				f--;
			else {
				Coordinate swap = list.get(i);
				list.set(i, list.get(f));
				list.set(f, swap);
				i++;
				f--;
			}
		}
		list.set(start, list.get(f));
		list.set(f, pivot);
		return f;
	}

}
