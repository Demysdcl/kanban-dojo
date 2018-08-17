function loadApp() {

    const boardsElement = document.getElementById('boards')

    const removeAllChildrenOf = element => {
        while (element.firstChild) {
            element.firstChild.remove()
        }
    }

    const boardTo = elementName => board => {
        const element = document.createElement(elementName)
        element.appendChild(document.createTextNode(board.name))
        return element
    }

    const loadBoardsOn = element => boards => {
        removeAllChildrenOf(element)
        boards
            .map(boardTo('li'))
            .forEach(li => element.appendChild(li))
    }

    fetch('http://localhost:8080/boards')
        .then((resp) => resp.json())
        .then(loadBoardsOn(boardsElement))
        .catch((err) => console.error(err))

    document
        .getElementById('insertBtn')
        .onclick = () => console.log(boardsElement.value)
}