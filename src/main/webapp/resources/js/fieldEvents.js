function timetableGroupIsChanged(courseid, groupid) {
    var groupSelectionForm = document.forms["timetableGroupSelectionForm"];

    debugger
    groupSelectionForm.setAttribute("action", "/timetable?groupid=" + groupid + "&course=" + courseid);

    groupSelectionForm.submit();
}

function studentsGroupIsChanged(courseid, groupid) {
    var groupSelectionForm = document.forms["studentsGroupSelectionForm"];

    debugger
    groupSelectionForm.setAttribute("action", "/students?groupid=" + groupid + "&course=" + courseid);

    groupSelectionForm.submit();
}
