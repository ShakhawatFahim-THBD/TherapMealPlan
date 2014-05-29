function setEditable(breakfastFieldId, lunchFieldId) {
    document.getElementById(breakfastFieldId).readOnly = false;
    document.getElementById(lunchFieldId).readOnly = false;
    document.getElementById(breakfastFieldId).style.color = "blue";
    document.getElementById(lunchFieldId).style.color = "blue";
}
