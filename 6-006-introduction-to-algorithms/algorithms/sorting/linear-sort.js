function countingSort(list) {
  let sortedList = list.map((e) => 0);
  list.forEach((e) => {
    let b = e % 10;
    if (!sortedList[b]) {
      sortedList[b] = e;
    } else {
      if (sortedList[b].length) {
        sortedList[b] = [...sortedList[b], e];
      } else {
        sortedList[b] = [sortedList[b], e];
      }
    }
  });
  // console.log(sortedList);
  const bList = sortedList.flat();
  sortedList = list.map((e) => 0);
  bList.forEach((e) => {
    let b = e % 100;
    if (!sortedList[b]) {
      sortedList[b] = e;
    } else {
      if (sortedList[b].length) {
        sortedList[b] = [...sortedList[b], e];
      } else {
        sortedList[b] = [sortedList[b], e];
      }
    }
  });
  return sortedList;
}
const list = [32, 3, 44, 42, 22];

console.log(countingSort(list).filter((e) => !!e));
