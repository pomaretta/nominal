import colors from './colors.js'

const colorTransform = (color,string) => {
    return (`${color}${string}${colors.RESET}`)
}

export default colorTransform