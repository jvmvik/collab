package com.arm.nimbus.collab.shared;

import java.util.List;

public interface Page<T> {
	  int getDataSize();

	  List<T> getPage();

	  int getStartIndex();

	  void setDataSize(int value);

	  void setPage(List<T> value);

	  void setStartIndex(int value);
}